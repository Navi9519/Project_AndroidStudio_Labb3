    package com.navi9519.labb_3_cocktail_app.viewmodels.userViewModel

    import androidx.compose.runtime.mutableIntStateOf
    import androidx.compose.runtime.mutableLongStateOf
    import androidx.compose.runtime.mutableStateOf
        import androidx.lifecycle.ViewModel
        import androidx.lifecycle.viewModelScope
        import com.navi9519.labb_3_cocktail_app.model.api.DrinksAPI
        import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
        import com.navi9519.labb_3_cocktail_app.model.database.user.User
        import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
    import kotlinx.coroutines.coroutineScope
    import kotlinx.coroutines.flow.launchIn
        import kotlinx.coroutines.flow.onEach
        import kotlinx.coroutines.launch

        class UserViewModel(private val userRepository: UserRepository) : ViewModel() {


            var username = mutableStateOf("")
            var userId = mutableLongStateOf(0)

            fun login(username: String, password: String, onLoginResult: (Boolean) -> Unit) {
                userRepository.findUserByUsernameAndPassword(username, password)
                    .onEach { user ->
                        val isUserLoggedIn = user != null
                        onLoginResult(isUserLoggedIn)
                    }
                    .launchIn(viewModelScope)
            }

            fun setUserIDbyUsername (username: String) {
                viewModelScope.launch {
                    userRepository.findExistingUser(username).collect {     // Database Query

                        val optionalId = it?.userId
                        if (optionalId != null) {
                            userId.longValue = optionalId
                        }

                    }
                }
            }

            fun register(username: String, onRegisterResult: (Boolean) -> Unit) {
                userRepository.findExistingUser(username)
                    .onEach { user ->
                        val usernamesIsRegistered = user?.name == username
                        onRegisterResult(usernamesIsRegistered)
                    }
                    .launchIn(viewModelScope)


            }



            }



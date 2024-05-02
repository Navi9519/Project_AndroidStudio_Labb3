import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class UserExistViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun login(username: String, password: String, onLoginResult: (Boolean) -> Unit) {
        userRepository.findUserByUsernameAndPassword(username, password)
            .onEach { user ->
                val isUserLoggedIn = user != null
                onLoginResult(isUserLoggedIn)
            }
            .launchIn(viewModelScope)
    }
}
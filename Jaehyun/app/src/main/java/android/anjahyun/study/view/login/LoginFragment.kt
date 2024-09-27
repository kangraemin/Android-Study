package android.anjahyun.study.view.login

import android.anjahyun.study.R
import android.anjahyun.study.ui.theme.StudyTheme
import android.anjahyun.study.util.showToast
import android.anjahyun.study.viewmodel.LoginViewModel
import android.anjahyun.study.viewmodel.SharedViewModel
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                LoginScreen(viewModel)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginResult.observe(viewLifecycleOwner, Observer {
            if (it) {
                requireContext().showToast(resources.getString(R.string.login10))
                findNavController().popBackStack()
            }
            else requireContext().showToast(resources.getString(R.string.login11))
        })
    }

}

@Composable
private fun LoginScreen(viewModel: LoginViewModel) {
    LoginView(onLoginClicked = {id, pw -> viewModel.login(id, pw)})
}

@Composable
private fun LoginView(onLoginClicked: (String, String) -> Unit) {
    var inputId by remember { mutableStateOf("delivery") }
    var inputPw by remember { mutableStateOf("dev_baemin") }
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxWidth()
        //modifier = Modifier.fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            //Modifier.width(IntrinsicSize.Max)
            //horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            IconButton(
                onClick = {
                    //findNavController().popBackStack()
                }
            ) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "닫기 버튼", tint = Color.Black)
            }
            TextField(
                value = inputId ,
                onValueChange = { inputId = it },
                maxLines = 1,
                placeholder = { Text(text = stringResource(id = R.string.login1)) },
                textStyle = TextStyle(color = Color.Black)
                //keyboardType = KeyboardType.Text,
                //imeAction = ImeAction.Next
            )
            TextField(
                value = inputPw ,
                onValueChange = { inputPw = it },
                maxLines = 1,
                placeholder = { Text(text = stringResource(id = R.string.login2)) }
                //keyboardType = KeyboardType.Text,
                //imeAction = ImeAction.Next
            )
            Button(
                onClick = { onLoginClicked(inputId, inputPw) },
                modifier = Modifier.background(colorResource(id = R.color.main))
            ) {
                Text(text = stringResource(id = R.string.login))
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { context.showToast(context.resources.getString(R.string.nothing)) }) {
                    Text(text = stringResource(id = R.string.login3))
                }
                Button(onClick = { context.showToast(context.resources.getString(R.string.nothing)) }) {
                    Text(text = stringResource(id = R.string.login4))
                }
            }

        }
    }


}


@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun DefaultPreview() {
    LoginView { id, pw -> {} }
}
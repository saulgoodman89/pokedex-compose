/*
 * Designed and developed by 2024 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.pokedex.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import com.skydoves.pokedex.compose.core.navigation.AppComposeNavigator
import com.skydoves.pokedex.compose.core.navigation.LocalComposeNavigator
import com.skydoves.pokedex.compose.core.navigation.PokedexScreen
import com.skydoves.pokedex.compose.ui.PokedexMain
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject
  internal lateinit var composeNavigator: AppComposeNavigator<PokedexScreen>

  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)

    setContent {
      /*
        CompositionLocal : Jetpack Compse에서 테마 , 로케일 , 컨텍스트 등 여러 컴포넌트에서 사용되는 값을 전달 할 때 사용.
        명시적 : 컴포넌트의 매개변수로 값을 직접 전달
        암시적 : CompositionLocal을 사용하여 하위 컴포넌트에 값을 전달.

        CompositionLocalProvider : CompositionLocal에 값을 제공하는 컴포저블. 이를 통해 특정 컴포저블 트리의 하위 컴포넌트들이 해당 값을 사용.
       */
      CompositionLocalProvider(
        /*
          CompositionLocalProvider를 이용해 LocalComposeNavigator에  composeNavigator 값을 제공
         */
        LocalComposeNavigator provides composeNavigator,
      ) {
        PokedexMain(composeNavigator = composeNavigator)
      }
    }
  }
}

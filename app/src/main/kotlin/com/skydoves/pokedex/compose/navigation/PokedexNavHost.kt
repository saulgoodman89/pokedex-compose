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

package com.skydoves.pokedex.compose.navigation

import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.skydoves.pokedex.compose.core.navigation.PokedexScreen

@Composable
fun PokedexNavHost(navHostController: NavHostController) {
  /*
    SharedTransitionLayout
    두 화면 사이에 공통으로존재하는 요소(이미지 , 아이콘 텍스트 등)가 부드럽게 이동하거나 변형되는 효과를 말한다.

   */
  SharedTransitionLayout {
    /*
      네비게이션 그래프 설정.
     */
    NavHost(
      navController = navHostController,
      startDestination = PokedexScreen.Home,
    ) {
      pokedexNavigation()
    }
  }
}

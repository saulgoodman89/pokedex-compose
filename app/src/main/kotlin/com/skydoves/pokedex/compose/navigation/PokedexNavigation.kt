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

import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.skydoves.pokedex.compose.core.navigation.PokedexScreen
import com.skydoves.pokedex.compose.feature.details.PokedexDetails
import com.skydoves.pokedex.compose.feature.home.PokedexHome

context(SharedTransitionScope)
/*
  NavHost
    - 네비게이션 호스트 , 현재 활성화된 스크린을 표시하고 관리
  NavGraphBuilder
    - 네비게이션 그래프를 구성하는 빌더 객체.
 */
fun NavGraphBuilder.pokedexNavigation() {
  /*
    PokedexScreen.Home을 정의.
    composabledms NavGraphBuilder의 확장 함수.
   */
  composable<PokedexScreen.Home> {
    PokedexHome(this)
  }

  composable<PokedexScreen.Details>(
    typeMap = PokedexScreen.Details.typeMap,
  ) {
    PokedexDetails(this)
  }
}

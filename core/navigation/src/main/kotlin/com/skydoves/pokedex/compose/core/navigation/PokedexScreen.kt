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

package com.skydoves.pokedex.compose.core.navigation

import com.skydoves.pokedex.compose.core.model.Pokemon
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

/*

 */
sealed interface PokedexScreen {
  @Serializable // 직렬화 , 역직렬화가 가능하게 한다.
  data object Home : PokedexScreen  // data object : 싱글톤 객체를 데이터클래스 처럼 정의 할 수 있게 한다. 유일한 오브젝트를 가지며 데이터 클래스의 일부 기능을 제공.

  @Serializable
  data class Details(val pokemon: Pokemon) : PokedexScreen {
    companion object {
      val typeMap = mapOf(typeOf<Pokemon>() to PokemonType)
    }
  }
}

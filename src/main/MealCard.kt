package main

import react.RBuilder
import react.dom.*
import kotlin.js.Date

fun RBuilder.MealCard(meal: String, author: String, date: String, score: Int) {
    section("meal-card") {
        div("meal-card__name") {
            h2 { +meal }
            p { +author }
        }

        div("meal-card__info") {
            span { +date }
            div("meal-card__info-score") {
                (1..score).forEach {
                    i("fas fa-star") { }
                }

                (score until 5).forEach {
                    i("far fa-star") { }
                }
            }
        }
    }
}

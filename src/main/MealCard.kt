package main

import react.RBuilder
import react.dom.*
import kotlin.js.Date

fun RBuilder.MealCard(meal: String, author: String, date: Date, score: Int) {
    section("meal-card") {
        div("meal-card__name") {
            h2 { +meal }
            p { +author }
        }

        div("meal-card__info") {
            span { +date.toLocaleDateString() }
            div("meal-card__info-score") {
                for (point in 1..score) {
                    span { +"🌟" }
                }
            }
        }
    }
}
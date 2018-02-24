package main

import model.Meal
import org.w3c.fetch.RequestInit
import react.*
import react.dom.section
import kotlin.browser.window
import kotlin.js.json

class App : RComponent<RProps, ApplicationState>() {

    init {
        state = ApplicationState(emptyArray())
    }

    override fun componentDidMount() {
        getMeals()
    }

    override fun RBuilder.render() {
        section("app") {
            CreateForm(::createMeal)
            for (meal in state.meals) {
                MealCard(meal.name, meal.author, meal.date, meal.score)
            }
        }
    }

    private fun createMeal(
        name: String, author: String, date: String, score: Int
    ) {
        window.fetch("http://localhost:8080/meals", object: RequestInit {
            override var method: String? = "POST"
            override var body: dynamic = JSON.stringify(Meal(author, name, date, score))
            override var headers: dynamic = json("Content-Type" to "application/json")
        })
            .then {
                getMeals()
            }
    }

    private fun getMeals() {
        window.fetch("http://localhost:8080/meals").then {
            it.json()
        }
            .then {
                setState {
                    meals = it as Array<Meal>
                }
            }
    }
}


class ApplicationState(var meals: Array<Meal>) : RState

fun RBuilder.app() = child(App::class) {}

package main

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.section
import kotlin.js.Date

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        section("app") {
            CreateForm()
            MealCard("foo", "bar", Date(), 5)
        }
    }
}

fun RBuilder.app() = child(App::class) {}

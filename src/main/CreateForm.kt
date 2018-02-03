package main

import components.Button.Button
import kotlinx.html.InputType
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import kotlin.browser.window

class CreateForm : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        form(classes = "form") {
            h1("form__title") {
                +"Agappe"
            }

            div("form__main-inputs") {
                Button("Crear", {
                    window.alert("hola")
                }, extraStyles = "form__main-inputs__button")

                input(classes = "form__main-inputs__input") {
                    attrs {
                        placeholder = "Título del agape"
                    }
                }

                input {
                    attrs {
                        placeholder = "Autor"
                    }
                }

                input {
                    attrs {
                        type = InputType.date
                    }
                }

            }
        }
    }

}

fun RBuilder.CreateForm() = child(CreateForm::class) {}

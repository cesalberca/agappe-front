package main

import components.Button.Button
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*

interface CreateFormProps : RProps {
    var handleClick: (name: String, author: String, date: String, score: Int) -> Unit
}

interface CreateFormState : RState {
    var name: String
    var author: String
    var date: String
    var score: String
}

class CreateForm(props: CreateFormProps) : RComponent<CreateFormProps, CreateFormState>(props) {

    override fun CreateFormState.init(props: CreateFormProps) {
        name = ""
        author = ""
        date = ""
        score = "0"
    }

    override fun RBuilder.render() {
        form(classes = "form") {
            attrs {
                onSubmitFunction = {
                    it.preventDefault()
                }
            }
            h1("form__title") {
                +"Agappe"
            }

            div("form__main-inputs") {
                Button("Crear", {
                    props.handleClick(state.name, state.author, state.date, state.score.toInt())
                    resetState()
                }, extraStyles = "form__main-inputs__button")

                input(classes = "form__main-inputs__input") {
                    attrs {
                        placeholder = "Título del agape"
                        value = state.name
                        onChangeFunction = {
                            val target = it.target as HTMLInputElement
                            setState {
                                name = target.value
                            }
                        }
                    }
                }

                input {
                    attrs {
                        placeholder = "Autor"
                        value = state.author
                        onChangeFunction = {
                            val target = it.target as HTMLInputElement
                            setState {
                                author = target.value
                            }
                        }
                    }
                }

                input {
                    attrs {
                        type = InputType.date
                        value = state.date
                        onChangeFunction = {
                            val target = it.target as HTMLInputElement
                            setState {
                                date = target.value
                            }
                        }
                    }
                }

                input {
                    attrs {
                        type = InputType.number
                        min = "0"
                        max = "5"
                        value = state.score
                        onChangeFunction = {
                            val target = it.target as HTMLInputElement
                            setState {
                                score = target.value
                            }
                        }
                    }
                }

            }
        }
    }

    private fun resetState() {
        setState {
            author = ""
            name = ""
            date = ""
            score = "0"
        }
    }

}

fun RBuilder.CreateForm(handleClick: (name: String, author: String, date: String, score: Int) -> Unit) =
    child(CreateForm::class) {
        attrs.handleClick = handleClick
    }

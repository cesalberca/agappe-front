package components.Button

import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.dom.button

fun RBuilder.Button(text: String, click: (Any?) -> Unit, extraStyles: String) {
    button(classes = "button") {
        attrs {
            onClickFunction = click
            classes += extraStyles
        }
        +text
    }
}

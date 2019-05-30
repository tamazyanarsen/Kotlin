package com.example.demo.view

import javafx.collections.FXCollections
import tornadofx.*

import com.dls.jpos.common.*
import com.dls.jpos.interpretation.*
import jpos.*
import jpos.events.*

class MainView : View("Hello TornadoFX") {
    val scanner: Scanner = Scanner()
    override val root = vbox {
        combobox<String> {
            items = FXCollections.observableArrayList("Type 1", "Type 2")
        }
        hbox {
            button("Open") {
                action {
                    try {
                        val res = scanner.open("DLS-Magellan-RS232-Scanner-2200")
                        println("result: $res")
                    } catch (jp: JposException) {
                        println("was exception: $jp")
                    }
                }
            }
            button("Close") {
                action { scanner.close() }
            }
        }
    }
}

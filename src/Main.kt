package code0n.lab6

import java.awt.EventQueue
import javax.swing.*

class mainFrame(): JFrame() {
    init {
        createUI()
    }

    private fun createUI() {
        title = "Лабораторная работа №6"
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 300)
        setLocationRelativeTo(null)
    }
}

private fun createAndShowGUI() {
    val frame = mainFrame()
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}
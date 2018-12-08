package code0n.lab6

import java.awt.EventQueue
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import javax.swing.*

class mainFrame(): JFrame() {
    init {
        createUI()
    }

    private fun createUI() {
        title = "Лабораторная работа №6"
        createMenu()
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 300)
        setLocationRelativeTo(null)
    }

    private fun createMenu() {
        val mBar = JMenuBar()
        val mFile = JMenu("Файл")
        mFile.mnemonic = KeyEvent.VK_F
        val eMenuItem = JMenuItem("Создать")
        eMenuItem.mnemonic = KeyEvent.VK_C
        eMenuItem.toolTipText = "Создать окно"
        eMenuItem.addActionListener{ System.exit(0) }
        mFile.add(eMenuItem)
        mBar.add(mFile)
        jMenuBar = mBar
    }
}

private fun createAndShowGUI() {
    val frame = mainFrame()
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}
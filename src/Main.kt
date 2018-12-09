package code0n.lab6

import java.awt.EventQueue
import java.awt.event.ActionEvent
import java.awt.FlowLayout;
import java.awt.event.KeyEvent
import javax.swing.*

class mainFrame(): JFrame() {

    var selected: Boolean = false
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
        eMenuItem.addActionListener{
            val frame = secondFrame(this)
            frame.isVisible = true
        }
        mFile.add(eMenuItem)
        mBar.add(mFile)
        jMenuBar = mBar
    }

    fun react(tableType: Boolean) {
        if (tableType) {
            println("Таблица умножения")
        }
        else {
            println("Таблица сложения")
        }
    }
}

class secondFrame(mf: mainFrame): JFrame() {
    var mframe: mainFrame? = null
    init {
        mframe = mf
        createUI()
    }

    private fun createUI() {
        title = "Сделай свой выбор"
        val tUmn = JRadioButton("Отображать таблицу умножения")
        val tSlo = JRadioButton("Отображать таблицу сложения")

        val group = ButtonGroup()
        tUmn.addActionListener {
            mframe!!.react(true)
        }
        tSlo.addActionListener {
            mframe!!.react(false)
        }
        group.add(tUmn)
        group.add(tSlo)
        layout = FlowLayout()
        add(tUmn)
        add(tSlo)
        pack()
    }
}

private fun createAndShowGUI() {
    val frame = mainFrame()
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}
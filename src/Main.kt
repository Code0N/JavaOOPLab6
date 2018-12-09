package code0n.lab6

import java.awt.EventQueue
import java.awt.event.ActionEvent
import java.awt.FlowLayout;
import java.awt.event.KeyEvent
import javax.swing.*

class mainFrame(): JFrame() {
    val tArea = JTextArea(60, 60)
    init {
        createUI()
    }

    private fun createUI() {
        title = "Лабораторная работа №6"
        layout = FlowLayout()
        createMenu()
        add(tArea)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 300)
        setLocationRelativeTo(null)
        pack()
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
        val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        tArea.append("   *|")
        for (i in numbers) {
            tArea.append("%4d".format(i))
        }
        tArea.append("   |*")
        tArea.append("\n———————————————————————————————————————————————————\n")
        for (i in numbers) {
            tArea.append("%2d |".format(i))
            for (j in numbers) {
                if (tableType){
                    tArea.append("%4d".format(i*j))
                }
                else {
                    tArea.append("%4d".format(i+j))
                }
            }
            tArea.append("   |%2d".format(i))
            tArea.append("\n")
        }
    }
}

class secondFrame(mf: mainFrame): JFrame() {
    var mframe: mainFrame = mf
    init {
        //mframe = mf
        createUI()
    }

    private fun createUI() {
        title = "Сделай свой выбор"
        val tUmn = JRadioButton("Отображать таблицу умножения")
        val tSlo = JRadioButton("Отображать таблицу сложения")

        val group = ButtonGroup()
        tUmn.addActionListener {
            mframe.react(true)
            this.isVisible = false
        }
        tSlo.addActionListener {
            mframe.react(false)
            this.isVisible = false
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
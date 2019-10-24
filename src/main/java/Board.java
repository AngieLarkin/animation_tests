import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// тащим звезду с верхнего левого до правого нижнего угла
public class Board extends JPanel implements ActionListener {


    // Первые две констаны = размеры рамки, вторые две = начальные координаты звезды, последняя = скорость перемещения
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Image star;
    private Timer timer;
    private int x, y;

    public Board(){
        initBoard();
    }
    // метод загрузки изображения
    private void loadImage(){

        ImageIcon ii = new ImageIcon("src/main/resources/1.png");
        star = ii.getImage();
    }

    private void initBoard(){
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;
        // создаем таймер и запускаем его "Старт"  он кстати вызывает actionperfomed и опращивает его каждый шаг
        timer = new Timer(DELAY,this);
        timer.start();
    }

    // родительский метод отрисовки, вызывает метод в котором всё рисуется, туфтология какая то, но говорят это правильно

    @Override
    public  void paintComponent(Graphics g){
        super.paintComponent(g);

        drawStar(g);
    }
     // на самом деле всё рисуется тут
    private void drawStar(Graphics g) {
        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync(); // вот это важная ерунда которя синхронится с системным графическим буфером. Без неё анимация может дёргаться на некоторых платфромах
    }


    // тот самый метод который вызывается таймером
    @Override
    public void actionPerformed(ActionEvent e) {
     // указываем в куда будет падать звезда
        x += 1;
        y += 1;
     // как тотлько она провалится за экран -  рисуем заново
        if (y > B_HEIGHT) {
            y = INITIAL_Y;
            x = INITIAL_X;
        }
        repaint();
    }
}

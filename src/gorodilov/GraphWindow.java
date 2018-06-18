package gorodilov;

/* Суть данной игры: Необходимо попасть мышкой в центр, однако пули сносит ветром и дрожит рука
 с рандомной погрешностью 100+\-, за центр считается отметка 200х200 в изначальном размере окна 400х400.
 Пока знаний очистить экран и отцентровать граммотно c изменением размера окна не хватает.
  */




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GraphWindow extends JFrame {
    public JFrame viewForm;

    Random random = new Random();
    public GraphWindow() {



        setTitle("Убей меня в центр");

        Label myLabel = new Label("Координаты");
        add(myLabel, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 400);


        setLayout(new FlowLayout());
        JPanel panel = new JPanel() {
            Graphics2D graphics2D;
        };


        setContentPane(panel);

        JButton JBtns = new JButton("Новая игра");
        add(JBtns);

        JBtns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
                       {
                           dispose();
                        new GraphWindow();
                        }
          });






        panel.addMouseListener(new MouseAdapter() {


            @Override
            public void mouseClicked(MouseEvent e) {

                int numbers = random.nextInt(50);
                int numbers2 = -(random.nextInt(50));

                int x=e.getX() + numbers + numbers2;
                int y=e.getY() - numbers - numbers2;



                System.out.println("Координаты мушки: " + e.getX() + "  " + e.getY());
                System.out.println("Выстрел: " + x + "  " + y);
                System.out.println("Центр мишени: " + (rootPane.getX()+192) + "  " + (rootPane.getY()+170));

                getGraphics().drawOval(x, y, 10, 10);
                getGraphics().fillOval(x, y, 10, 10);
                int i=21;
                int i1=-21;


                if (((rootPane.getX()-x+192) > i1) && ((rootPane.getX()-x+192) < i) && ((rootPane.getY()-y+170) < i) && ((rootPane.getY()-y+170) > i1))
                {
                    getGraphics().drawString("Убил...",100,100);
                    JOptionPane.showMessageDialog(viewForm, "Прям в центр! Играем еще?",
                            "Молодец!", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new GraphWindow();

                }


            }


        });


        setVisible(true);
}

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawOval(rootPane.getX(), rootPane.getY(), rootPane.getWidth(), rootPane.getHeight());

    }


}

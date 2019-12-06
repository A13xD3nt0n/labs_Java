import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WorkerText extends JFrame {

    private JButton result = new JButton("Получить результаты");
    private JTextField data = new JTextField("Введите текст");
    private JTextField count = new JTextField();
    private JTextField deleter = new JTextField();
    private JTextField sorter = new JTextField();

    public WorkerText() {
        super("Лабораторная работа 5");
        data.setFont(new Font("Dialog", Font.BOLD, 18));
        count.setFont(new Font("Dialog", Font.BOLD, 18));
        deleter.setFont(new Font("Dialog", Font.BOLD, 18));
        sorter.setFont(new Font("Dialog", Font.BOLD, 18));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(data);
        mainPanel.add(result);
        mainPanel.add(count);
        mainPanel.add(deleter);
        mainPanel.add(sorter);
        result.setAlignmentX(CENTER_ALIGNMENT);
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Text text = new Text(data.getText());
                count.setText(Integer.toString(text.countSigns()));
                deleter.setText(text.printWithChoice());
                sorter.setText(text.printSort());
            }
        });
        setLocationByPlatform(true);
        setContentPane(mainPanel);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        WorkerText app = new WorkerText();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guide{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Guide");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton button = new JButton("Click Me");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showGuide(button);
                }
            });

            frame.setLayout(new FlowLayout());
            frame.add(button);

            frame.setVisible(true);
        });
    }

    private static void showGuide(Component component) {
        JToolTip toolTip = new JToolTip();
        toolTip.setTipText("\nThis is a guide.how to use this system for user :first you have to signup with your mobile no after 2 hour of your appliction\n and then login and explore your menu bar\n");

        Point location = component.getLocationOnScreen();
        toolTip.setLocation(location.x + 20, location.y - 30); // Adjust location as needed

        JWindow window = new JWindow();
        window.getContentPane().add(toolTip);
        window.setSize(toolTip.getPreferredSize());
        window.setLocation(location.x + 20, location.y - 30); // Adjust location as needed
        window.setVisible(true);

        // Close the tooltip after some time (e.g., 3 seconds)
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mainForm {
    private JPanel mainForm;
    private JButton btn_viewTimeline;
    private JButton btn_viewFigures;
    private JButton btn_createEvent;
    private JButton btn_createFigure;
    private JButton btn_EditEvent;
    static ArrayList<creator> crtr = new ArrayList<>();
    public static JFrame frame = new JFrame("Main Form");




    public mainForm() {
        btn_createFigure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addFigure().setAddFig();
            }
        });
        btn_createEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addEvent().setAddEventPanel();
            }
        });
        btn_viewTimeline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new timeline1900().setTimeline1990();

            }
        });
        btn_viewFigures.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new viewFigures().setViewFigures();
            }
        });
        btn_EditEvent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                editEvent.editEventSetup();
            }
        });
    }


    public static void setMainForm() {
        frame.setContentPane(new mainForm().mainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }

}

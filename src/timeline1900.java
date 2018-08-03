import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

public class timeline1900 {
    private JPanel timeline1990;
    private JSlider JSld_years;
    private JLabel lbl_title;
    private JLabel lbl_startDate;
    private JLabel lbl_details;
    private JLabel lbl_link;
    private JTextField txt_title;
    private JTextField txt_startName;
    private JTextField txt_EndDate;
    private JTextField txt_details;
    private JTextField txt_Link;
    private JLabel imageLogo;
    private JLabel lbl_Event;
    static ArrayList<Event> aEvent = new ArrayList<>();



    public timeline1900() {

        JPanel Content = new JPanel();
        Content.setLayout(new GridBagLayout());

        JSld_years.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                dataHandle.readEventFromFile();
                txt_Link.setText("");
                txt_details.setText("");
                txt_title.setText("");
                txt_startName.setText("");
                txt_EndDate.setText("");
                for (int inx = 0; inx < aEvent.size(); inx++) {
                    int sD = aEvent.get(inx).getStartDate();
                    int cD = JSld_years.getValue();

                    if (sD == cD) {
                        txt_title.setText(aEvent.get(inx).getTitle());
                        txt_startName.setText(String.valueOf(aEvent.get(inx).getStartDate()));
                        txt_EndDate.setText(String.valueOf(aEvent.get(inx).getEndDate()));
                        txt_details.setText(aEvent.get(inx).getDetails());
                        txt_Link.setText(aEvent.get(inx).getLinks());

                        imageLogo = new JLabel(new ImageIcon(aEvent.get(inx).getImg()));

                    }
                }
            }
        });
    }



    public static void setTimeline1990() {
        JFrame frame = new JFrame("timeline1900");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new timeline1900().timeline1990);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents()
    {
        imageLogo = new JLabel(new ImageIcon("images/logo.png"));
    }
}





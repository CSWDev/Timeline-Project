import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class editEvent
{
    private JPanel editEvent;
    private JLabel lbl_enterID;
    private JTextField txt_title;
    private JLabel lbl_startDate;
    private JLabel lbl_endDate;
    private JLabel lbl_details;
    private JLabel lbl_links;
    private JLabel lbl_imgpath;
    private JTextField txt_sYr;
    private JTextField txt_eYr;
    private JTextField txt_det;
    private JTextField txt_link;
    private JTextField txt_img;
    private JButton btn_search;
    private JButton btn_delete;
    private JButton btn_edit;
    private JButton btn_save;
    public static JFrame frame = new JFrame("editEvent");
    static ArrayList<Event> aEvent = new ArrayList<>();


    public editEvent()
    {
        btn_search.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                search();
            }
        });
        btn_edit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                edit();
            }
        });
    }

    public void search(){
            dataHandle.readEventFromFile();
            String searchTitle = txt_title.getText();
            txt_title.setEnabled(true);
            for (int i =0; i < aEvent.size(); i++){
                if(searchTitle.equals(aEvent.get(i).getTitle())){
                    txt_sYr.setText(String.valueOf(aEvent.get(i).getStartDate()));
                    txt_eYr.setText(String.valueOf(aEvent.get(i).getEndDate()));
                    txt_title.setText(aEvent.get(i).getTitle());
                    txt_img.setText(aEvent.get(i).getImg());
                    txt_det.setText(aEvent.get(i).getDetails());
                    txt_link.setText(aEvent.get(i).getLinks());
                }
            }
        txt_sYr.setEnabled(false);
        txt_eYr.setEnabled(false);
        txt_link.setEnabled(false);
        txt_det.setEnabled(false);
        txt_img.setEnabled(false);
    }

    public void edit(){
        txt_sYr.setEnabled(true);
        txt_eYr.setEnabled(true);
        txt_link.setEnabled(true);
        txt_det.setEnabled(true);
        txt_img.setEnabled(true);
        txt_title.setEnabled(false);
    }










    public static void editEventSetup(){
        JFrame frame = new JFrame("editEvent");
        frame.setContentPane(new editEvent().editEvent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

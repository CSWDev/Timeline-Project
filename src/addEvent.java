import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

public class addEvent
{
    private JLabel lbl_events;
    private JTextField txtbx_title;
    private JTextField txtbx_endDate;
    private JLabel lbl_title;
    private JLabel lbl_endDate;
    private JLabel lbl_startDate;
    private JLabel lbl_Details;
    private JPanel addEvent;
    private JButton selectImageButton;
    private JLabel lbl_addImage;
    private JButton btn_Confirm;
    private JButton btn_cancel;
    private JTextField txt_details;
    private JTextField txt_link;
    private JTextField txt_startDate;
    private JTextField txt_endDate;
    private JTextField txt_imagePath;
    private JLabel lbl_historicalFigure;
    private JComboBox cBx_historicalFigures;
    private JSpinner spn_StartDate;
    private JSpinner spn_endDate;
    final JFileChooser fc = new JFileChooser();


    protected String title;
    protected Integer sDate;
    protected Integer eDate;
    protected String Details;
    protected String link;
    protected String imgpath;
    protected String figures;
    static ArrayList<Figure> aFigure = new ArrayList<>();


    public addEvent()
    {
        btn_Confirm.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (txtbx_title.getText().equals("") || txt_startDate.getText().equals("") || txt_endDate.getText().equals("") || txt_details.getText().equals("") || txt_link.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a value.");
                }
                else
                {
                    sendData();

                }
            }
        });
        selectImageButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == selectImageButton)
                {
                    int returnVal = fc.showOpenDialog(addEvent);

                    if (returnVal == JFileChooser.APPROVE_OPTION)
                    {
                        File file = fc.getSelectedFile();
                        txt_imagePath.setText(file.toString());

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Cancelled");
                    }
                }
            }
        });
        txt_startDate.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char c = e.getKeyChar();
                if (!Character.isDigit(c))
                {
                    e.consume();
                }

            }
        });
        txt_endDate.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char c = e.getKeyChar();
                if (!Character.isDigit(c))
                {
                    e.consume();
                }
            }
        });

    }

    //setup the form for display
    public void setAddEventPanel()
    {
        JFrame frame = new JFrame("add Event");
        frame.setContentPane(new addEvent().addEvent);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void sendData()
    {

        title = txtbx_title.getText();
        sDate = Integer.parseInt(txt_startDate.getText());
        eDate = Integer.parseInt(txt_endDate.getText());
        Details = txt_details.getText();
        link = txt_link.getText();
        imgpath = txt_imagePath.getText();
        //add to event array
        Event evnt = new Event(title, sDate, eDate, Details, link, imgpath);
        dataHandle.event.add(evnt);

        try
        {
            dataHandle.saveEventToFile();
            JOptionPane.showMessageDialog(null, "Event Added");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}


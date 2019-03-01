import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.text.NumberFormat;

public class BookShop extends JFrame {

    // swing components
    private JList<String> bookList, cartList;
    private JButton addButton, removeButton, clearButton, checkoutButton, closeButton;
    private JPanel bookListPanel, cartListPanel, cartButtonPanel, cartPanel, checkoutPanel;
    private JScrollPane bookScrollPane, cartScrollPane;

    // Other
    private Scanner fileScanner;

    // Data members
    private String[] books;
    private String[] emptyCart = new String[] {};
    private float[] prices;
    private DefaultListModel<String> cartModel;

    // Constants
    private final int WINDOW_WIDTH = 500, WINDOW_HEIGHT = 210;

    // Init methods
    private void initialize() {

        // Initializes the JFrame
        initFrame();

        // Read File
        openFile();
        readFile();

        // Initialize Lists
        initLists();

        // Initialize Buttons
        initCartButtons();

        // Setup cart panel
        initCartPanel();

        // Setup checkout panel
        initCheckoutPanel();

        // Add to frame
        this.add(cartPanel, BorderLayout.NORTH);
        this.add(checkoutPanel, BorderLayout.SOUTH);

    }

    private void initFrame() {
        // Setup JFrame
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Book Store");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void openFile() {
        File bookFile = new File("BookPrices.txt");
        try {
            fileScanner = new Scanner(bookFile);
        } catch (FileNotFoundException e) {

        } finally {
            if (bookFile == null)
                fileScanner.close();
        }
    }

    private void readFile() {
        books = new String[7];
        prices = new float[7];

        for (int i = 0; i < 7; i++) {
            fileScanner.useDelimiter(", ");
            books[i] = fileScanner.next();
            fileScanner.useDelimiter("\n");
            prices[i] = Float.parseFloat(fileScanner.next().substring(2));
        }

        fileScanner.close();
    }

    private void initLists() {
        // Initialize book list
        bookListPanel = new JPanel();
        bookList = new JList<>(books);
        bookScrollPane = new JScrollPane(bookList);

        bookList.setVisibleRowCount(5);
        bookListPanel.add(bookScrollPane);

        // Initialize cart list
        cartListPanel = new JPanel();
        cartModel = new DefaultListModel<>();
        cartModel.addElement("-- Add an item to the cart --");
        cartList = new JList<>(emptyCart);
        cartList.setModel(cartModel);
        cartScrollPane = new JScrollPane(cartList);

        cartList.setVisibleRowCount(5);
        cartListPanel.add(cartScrollPane);
        cartListPanel.setPreferredSize(bookListPanel.getPreferredSize());
    }

    private void initCartButtons() {
        // Initialize panels
        cartButtonPanel = new JPanel();
        JPanel buttonHelperPanel = new JPanel();
        buttonHelperPanel.setLayout(new BorderLayout());

        // Setup buttons
        addButton = new JButton("Add      >>");
        addButton.addActionListener(new AddListener());
        addButton.setHorizontalAlignment(SwingConstants.CENTER);

        removeButton = new JButton("Remove <<");
        removeButton.addActionListener(new RemoveListener());
        removeButton.setHorizontalAlignment(SwingConstants.CENTER);

        clearButton = new JButton("Clear Cart");
        clearButton.addActionListener(new ClearListener());
        clearButton.setHorizontalAlignment(SwingConstants.CENTER);

        // Finish panels
        buttonHelperPanel.add(addButton, BorderLayout.NORTH);
        buttonHelperPanel.add(removeButton, BorderLayout.CENTER);
        buttonHelperPanel.add(clearButton, BorderLayout.SOUTH);
        buttonHelperPanel.setBorder(BorderFactory.createEmptyBorder(7, 0, 0, 0));

        cartButtonPanel.add(buttonHelperPanel);
    }

    private void initCartPanel() {
        cartPanel = new JPanel();
        cartPanel.setLayout(new BorderLayout());
        cartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        cartPanel.add(bookListPanel, BorderLayout.WEST);
        cartPanel.add(cartButtonPanel, BorderLayout.CENTER);
        cartPanel.add(cartListPanel, BorderLayout.EAST);

    }

    private void initCheckoutPanel() {
        // setup panel
        checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.LINE_AXIS));
        checkoutPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // setup buttons
        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new CheckoutListener(this));

        closeButton = new JButton("Exit");
        closeButton.addActionListener(new CloseListener());

        // add components
        checkoutPanel.add(Box.createHorizontalGlue());
        checkoutPanel.add(closeButton);
        checkoutPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        checkoutPanel.add(checkoutButton);
    }

    // Helper methods
    private float getPrice(String bookTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(bookTitle))
                return prices[i];
        }
        return 0.0f;
    }

    private float calcTax(float subtotal) {
        return subtotal * 0.06f;
    }

    private void close() {
        System.exit(0);
    }

    // Event Listeners
    private class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> selections = new ArrayList<>(bookList.getSelectedValuesList());

            if (selections.size() != 0) {
                if (cartModel.get(0).equals("-- Add an item to the cart --")) {
                    cartModel.removeAllElements();
                }

                for (int i = 0; i < selections.size(); i++) {
                    cartModel.addElement(selections.get(i));
                }
            }
        }
    }

    private class RemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> selections = new ArrayList<>(cartList.getSelectedValuesList());

            if (!cartModel.get(0).equals("-- Add an item to the cart --")) {
                for (int i = 0; i < selections.size(); i++) {
                    cartModel.removeElement(selections.get(i));
                }
            }
        }
    }

    private class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!cartModel.getElementAt(0).equals("-- Add an item to the cart --")) {
                cartModel.removeAllElements();
                cartModel.addElement("-- Add an item to the cart --");
            }
        }
    }

    private class CheckoutListener implements ActionListener {
        JFrame rootFrame;
        
        public void actionPerformed(ActionEvent e) {
            if(!cartModel.getElementAt(0).equals("-- Add an item to the cart --"))
            {
                float subtotal = 0, tax, total;
                for (int i = 0; i < cartModel.size(); i++) {
                    subtotal += getPrice(cartModel.get(i));
                }
                
                tax = calcTax(subtotal);
                total = subtotal + tax;

                String divider = "============================\n";

                String receipt = String.format(
                    "Receipt:\n\n" +
                    "Subtotal:                                   $%1$.2f\n" +
                    "Tax:                                              $%2$.2f\n" +
                    divider +
                    "Total:                                          $%3$.2f", 
                    subtotal, tax, total);

                JOptionPane.showMessageDialog(rootFrame, receipt, "Receipt", JOptionPane.PLAIN_MESSAGE);
            }

        }

        public CheckoutListener(JFrame frame) {
            rootFrame = frame;
        }
    }

    private class CloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            close();
        }
    }

    public BookShop() {
        initialize();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BookShop();

    }
}
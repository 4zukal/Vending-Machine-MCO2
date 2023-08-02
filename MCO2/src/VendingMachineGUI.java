import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class VendingMachineGUI extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;

    private Controller controller;
    private Payment payment;

    private ArrayList<Integer> userPayment = new ArrayList<>();

    public VendingMachineGUI() {
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        controller = new Controller();

        addMainMenu();
        addCreateVendingMachineScene();
        addTestVendingMachineScene();

        cardLayout.show(mainPanel, "MainMenu");
        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("Vending Machine GUI");
        setVisible(true);
    }

    private void addMainMenu() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));

        JButton createMachineButton = new JButton("Create a Vending Machine");
        createMachineButton.addActionListener(e -> cardLayout.show(mainPanel, "CreateMachine"));
        panel.add(createMachineButton);

        JButton testMachineButton = new JButton("Test a Vending Machine");
        testMachineButton.addActionListener(e -> cardLayout.show(mainPanel, "TestMachine"));
        panel.add(testMachineButton);



        mainPanel.add(panel, "MainMenu");
    }
    private void addCreateVendingMachineScene() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton createRegularMachineButton = new JButton("Create a Regular Vending Machine");
        createRegularMachineButton.addActionListener(e -> createRegularVendingMachine());
        panel.add(createRegularMachineButton);

        JButton createSpecialMachineButton = new JButton("Create a Special Vending Machine");
        createSpecialMachineButton.addActionListener(e -> createSpecialVendingMachine());
        panel.add(createSpecialMachineButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        panel.add(backButton);

        mainPanel.add(panel, "CreateMachine");
    }

    private void addTestVendingMachineScene() {

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

            JButton testRegularMachineButton = new JButton("Test a Regular Vending Machine");
            testRegularMachineButton.addActionListener(e -> testRegularVendingMachine(controller));
            panel.add(testRegularMachineButton);

            JButton testSpecialMachineButton = new JButton("Test a Special Vending Machine");
            testSpecialMachineButton.addActionListener(e -> testSpecialVendingMachine(controller));
            panel.add(testSpecialMachineButton);

            JButton backButton = new JButton("Go Back to Main Menu");
            backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
            panel.add(backButton);

            mainPanel.add(panel, "TestMachine");

    }






    private void createRegularVendingMachine() {
        double money = 0.0;
        String name = JOptionPane.showInputDialog(this, "Enter the name of the vending machine:", "Create a Regular Vending Machine", JOptionPane.QUESTION_MESSAGE);
        controller.SetRegVendName(name);

        int numOfProds = 0;
        while (numOfProds <= 0) {
            try {
                numOfProds = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the number of products:", "Create a Regular Vending Machine", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid number of products!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        controller.setNumOfProds(numOfProds);

        String[] prodNames = new String[numOfProds];
        for (int i = 0; i < numOfProds; i++) {
            prodNames[i] = JOptionPane.showInputDialog(this, "Enter the name of product #" + (i + 1) + ":", "Create a Regular Vending Machine", JOptionPane.QUESTION_MESSAGE);

        }
        controller.setProdNames(prodNames);

        double[] prodPrices = new double[numOfProds];
        for (int i = 0; i < numOfProds; i++) {
            prodPrices[i] = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the price of " + prodNames[i] + ":", "Create a Regular Vending Machine", JOptionPane.QUESTION_MESSAGE));

        }
        controller.setProdPrices(prodPrices);

        int[] prodQty = new int[numOfProds];
        for (int i = 0; i < numOfProds; i++) {
            prodQty[i] = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the quantity of product " + prodNames[i]  + ":", "Create a Regular Vending Machine", JOptionPane.QUESTION_MESSAGE));

        }
        controller.setProdQty(prodQty);

        double[] prodCalorie = new double[numOfProds];
        for (int i = 0; i < numOfProds; i++) {
            prodCalorie[i] = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the calorie of " + prodNames[i] + ":", "Create a Regular Vending Machine", JOptionPane.QUESTION_MESSAGE));

        }
        controller.setProdCalorie(prodCalorie);

        controller.initializeRegMoneyBox(money);
        controller.setRegPayment(0.0);



        JOptionPane.showMessageDialog(null, "You have successfully created a regular vending machine!");
    }


    private void testRegularVendingMachine(Controller controller) {

        if (controller.getRegVendName() == null) {
            JOptionPane.showMessageDialog(null, "Please create a regular vending machine first!");
        } else {
            double money = controller.getRegMoneyBox();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(Color.GRAY);

            // Display the name of the vending machine
            JLabel name = new JLabel(controller.getRegVendName());
            panel.add(name);

            // Create a header row
            JPanel headerRow = new JPanel(new GridLayout(1, 4, 10, 10));
            JLabel nameLabel = new JLabel("Name");
            headerRow.add(nameLabel);

            JLabel priceLabel = new JLabel("Price");
            headerRow.add(priceLabel);

            JLabel qtyLabel = new JLabel("Quantity");
            headerRow.add(qtyLabel);

            JLabel calorieLabel = new JLabel("Calorie");
            headerRow.add(calorieLabel);

            // Set line border for the header row
            Border headerBorder = BorderFactory.createLineBorder(Color.BLACK);
            headerRow.setBorder(headerBorder);
            panel.add(headerRow);

            // Display the products
            for (int i = 0; i < controller.getNumOfProds(); i++) {
                JPanel row = new JPanel(new GridLayout(1, 4, 10, 10));
                JLabel prodName = new JLabel(controller.getProdNames()[i]);
                row.add(prodName);

                JLabel prodPrice = new JLabel(String.valueOf(controller.getProdPrices()[i]));
                row.add(prodPrice);

                JLabel prodQty = new JLabel(String.valueOf(controller.getProdQty()[i]));
                row.add(prodQty);

                JLabel prodCalorie = new JLabel(String.valueOf(controller.getProdCalorie()[i]));
                row.add(prodCalorie);

                // Set line border for each row
                Border rowBorder = BorderFactory.createLineBorder(Color.BLACK);
                row.setBorder(rowBorder);
                panel.add(row);
            }



            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.setBackground(Color.GRAY);


            JButton maintenanceButton = new JButton("Maintenance");
            maintenanceButton.addActionListener(e -> regMaintenance(controller));
            buttonPanel.add(maintenanceButton);

            JButton insertButton = new JButton("Insert Money (Current Balance: " + controller.getRegPayment() +")");
            insertButton.addActionListener(e -> RegPayment(controller));
            buttonPanel.add(insertButton);

            JButton buyButton = new JButton("Buy");
            buyButton.addActionListener(e -> regBuy(controller));
            buttonPanel.add(buyButton);

            JButton changeButton = new JButton("get Change");
            changeButton.addActionListener(e -> regChange(controller));
            buttonPanel.add(changeButton);

            JButton backButton = new JButton("Go Back to Main Menu");
            backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
            buttonPanel.add(backButton);

            panel.add(buttonPanel); // Add the button panel beneath the products


            mainPanel.add(panel, "RegularVendingMachinePanel"); // Add the panel to mainPanel
            cardLayout.show(mainPanel, "RegularVendingMachinePanel");
        }
    }


    public void regMaintenance(Controller controller){
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.GRAY);


        //add item quantity
        JButton addItemButton = new JButton("Add Item Quantity");
        addItemButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter the name of the product:", "Add Item Quantity", JOptionPane.QUESTION_MESSAGE);
            int qty = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the added quantity:", "Add Item Quantity", JOptionPane.QUESTION_MESSAGE));
            controller.addItemQty(name, qty);
        });
        buttonPanel.add(addItemButton);
        JButton addMoneyBoxButton = new JButton("Add to MoneyBox(Current Money Box Balance: " + controller.getRegMoneyBox() + ")");
        addMoneyBoxButton.addActionListener(e -> {
            double money = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the Amount added: ", "Add Moneybox Amount", JOptionPane.QUESTION_MESSAGE));
            controller.addRegMoneyBox(money);
        });
        buttonPanel.add(addMoneyBoxButton);




        JButton backButton = new JButton("Go Back to Vending Machine");
        backButton.addActionListener(e -> testRegularVendingMachine(controller));
        buttonPanel.add(backButton);

        mainPanel.add(buttonPanel, "regMaintenance");
        cardLayout.show(mainPanel, "regMaintenance");
    }

    public void RegPayment(Controller controller) {
        String[] paymentOptions = {
                "1 Peso Coin",
                "5 Peso Coin",
                "10 Peso Coin",
                "20 Peso Coin/Bill",
                "50 Peso Bill",
                "100 Peso Bill",
                "200 Peso Bill",
                "500 Peso Bill",
                "1000 Peso Bill",
                "Cancel"
        };

        int result = JOptionPane.showOptionDialog(
                null,
                "Select a Bill/Coin:",
                "Payment Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                paymentOptions,
                paymentOptions[0]
        );

        if (result >= 0 && result < paymentOptions.length - 1) {
            String selectedOption = paymentOptions[result];
            JOptionPane.showMessageDialog(null, "Selected Bill/Coin: " + selectedOption);

            switch (selectedOption) {
                case "1 Peso Coin":
                    controller.addRegPayment(1.0);
                    break;
                case "5 Peso Coin":
                    controller.addRegPayment(5.0);
                    break;
                case"10 Peso Coin":
                    controller.addRegPayment(10.0);
                    break;
                case "20 Peso Coin/Bill":
                    controller.addRegPayment(20.0);
                    break;
                case "50 Peso Bill":
                    controller.addRegPayment(50.0);
                    break;

                case "100 Peso Bill":
                    controller.addRegPayment(100.0);
                    break;

                case "200 Peso Bill":
                    controller.addRegPayment(200.0);
                    break;
                case "500 Peso Bill":
                    controller.addRegPayment(500.0);
                    break;

                case "1000 Peso Bill":
                    controller.addRegPayment(1000.0);
                    break;

                default:
                    System.out.println("Payment canceled.");

             }
        }
        else {
            JOptionPane.showMessageDialog(null, "Payment canceled.");
        }

        testRegularVendingMachine(controller);
    }

    public void regBuy(Controller controller){

        double pay = controller.getRegPayment();

        String name = JOptionPane.showInputDialog(this, "Enter the name of the product:", "Buy Item", JOptionPane.QUESTION_MESSAGE);
        if (controller.getItemQty(name) <= 0){
            JOptionPane.showMessageDialog(null, "Out of Stock");
            testRegularVendingMachine(controller);
        }

        else {
            JOptionPane.showMessageDialog(null, name + " Bought!");
            double price = controller.getItemPrice(name);
            controller.buyItem(name, pay);
            controller.setRegPayment(pay - price);
            testRegularVendingMachine(controller);
        }
    }

    public void regChange(Controller controller){
        double change = controller.getRegPayment();
        controller.setRegPayment(0);
        JOptionPane.showMessageDialog(null, "Change: " + change);
        controller.setRegMoneyBox(controller.getRegMoneyBox() - change);
        testRegularVendingMachine(controller);
    }

    public void createSpecialVendingMachine(){
        // create a special vending machine
        String name = JOptionPane.showInputDialog(this, "Enter the name of the vending machine:", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE);
        controller.setSpecVendName(name);
        double money = 0.0;
        int numOfFlavors = 0;
        while (numOfFlavors <= 0) {
            try {
                numOfFlavors = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the number of Milk flavors:", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid number of flavors!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        controller.setSpecNumOfFlavors(numOfFlavors);

        String[] specFlavors = new String[numOfFlavors];
        for (int i = 0; i < numOfFlavors; i++) {
            specFlavors[i] = JOptionPane.showInputDialog(this, "Enter the name of flavor #" + (i + 1) + ":", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE);
        }
        controller.setSpecFlavors(specFlavors);

        double[] milkTeaFlavorCalories = new double[numOfFlavors];
        for (int i = 0; i < numOfFlavors; i++) {
            milkTeaFlavorCalories[i] = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the calorie of " + specFlavors[i] + ":", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE));
        }
        controller.setMilkTeaFlavorCalories(milkTeaFlavorCalories);

        double[] milkTeaFlavorPrices = new double[numOfFlavors];
        for (int i = 0; i < numOfFlavors; i++) {
            milkTeaFlavorPrices[i] = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the price of " + specFlavors[i] + ":", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE));
        }
        controller.setMilkTeaFlavorPrices(milkTeaFlavorPrices);

        int[] milkTeaFlavorServing = new int[numOfFlavors];
        for (int i = 0; i < numOfFlavors; i++) {
            milkTeaFlavorServing[i] = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the number of servings of " + specFlavors[i] + ":", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE));
        }
        controller.setMilkTeaFlavorServing(milkTeaFlavorServing);

        int numOfSinkers = 0;
        while (numOfSinkers <= 0) {
            try {
                numOfSinkers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the number of sinkers:", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid number of sinkers!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        controller.setNumOfSinkers(numOfSinkers);

        String[] sinkers = new String[numOfSinkers];
        for (int i = 0; i < numOfSinkers; i++) {
            sinkers[i] = JOptionPane.showInputDialog(this, "Enter the name of sinker #" + (i + 1) + ":", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE);
        }
        controller.setSinkers(sinkers);

        double[]  sinkerCalories = new double[numOfSinkers];
        for (int i = 0; i < numOfSinkers; i++) {
            sinkerCalories[i] = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the calorie of " + sinkers[i] + ":", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE));
        }
        controller.setSinkersCalories(sinkerCalories);

        double[] sinkerPrices = new double[numOfSinkers];
        for (int i = 0; i < numOfSinkers; i++) {
            sinkerPrices[i] = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the price of " + sinkers[i] + ":", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE));
        }
        controller.setSinkersPrices(sinkerPrices);



        int[] sinkerServing = new int[numOfSinkers];
        for (int i = 0; i < numOfSinkers; i++) {
            sinkerServing[i] = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the number of servings of " + sinkers[i] + ":", "Create a Special Vending Machine", JOptionPane.QUESTION_MESSAGE));
        }
        controller.setSinkersServing(sinkerServing);
        controller.initializeSpecMoneyBox(money);
        controller.setSpecPayment(0.0);

        JOptionPane.showMessageDialog(null, "You have successfully created a special vending machine!");


    }


    private void testSpecialVendingMachine(Controller controller) {
        if (controller.getSpecVendName() == null) {
            JOptionPane.showMessageDialog(null, "Please create a special vending machine first!");
        } else {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(Color.GRAY);

            // Display the name of the vending machine
            JLabel name = new JLabel(controller.getSpecVendName());
            panel.add(name);

            // Create a header row for Milk Tea flavors
            JPanel milkTeaHeaderRow = new JPanel(new GridLayout(1, 4, 10, 10));
            JLabel milkTeaNameLabel = new JLabel("Milk Tea Flavor");
            milkTeaHeaderRow.add(milkTeaNameLabel);

            JLabel milkTeaPriceLabel = new JLabel("Price");
            milkTeaHeaderRow.add(milkTeaPriceLabel);

            JLabel milkTeaQtyLabel = new JLabel("Quantity");
            milkTeaHeaderRow.add(milkTeaQtyLabel);

            JLabel milkTeaCalorieLabel = new JLabel("Calorie");
            milkTeaHeaderRow.add(milkTeaCalorieLabel);

            // Set line border for the header row
            Border milkTeaHeaderBorder = BorderFactory.createLineBorder(Color.BLACK);
            milkTeaHeaderRow.setBorder(milkTeaHeaderBorder);
            panel.add(milkTeaHeaderRow);

            // Display the Milk Tea flavors and their details
            String[] milkTeaFlavors = controller.getSpecFlavors();
            double[] milkTeaPrices = controller.getMilkTeaFlavorPrices();
            int[] milkTeaQuantities = controller.getMilkTeaFlavorServing();
            double[] milkTeaCalories = controller.getMilkTeaFlavorCalories();

            for (int i = 0; i < milkTeaFlavors.length; i++) {
                JPanel row = new JPanel(new GridLayout(1, 4, 10, 10));
                JLabel flavorName = new JLabel(milkTeaFlavors[i]);
                row.add(flavorName);

                JLabel flavorPrice = new JLabel(String.valueOf(milkTeaPrices[i]));
                row.add(flavorPrice);

                JLabel flavorQty = new JLabel(String.valueOf(milkTeaQuantities[i]));
                row.add(flavorQty);

                JLabel flavorCalorie = new JLabel(String.valueOf(milkTeaCalories[i]));
                row.add(flavorCalorie);

                // Set line border for each row
                Border rowBorder = BorderFactory.createLineBorder(Color.BLACK);
                row.setBorder(rowBorder);
                panel.add(row);
            }

            // Create a header row for Sinkers
            JPanel sinkerHeaderRow = new JPanel(new GridLayout(1, 3, 10, 10));
            JLabel sinkerNameLabel = new JLabel("Sinker");
            sinkerHeaderRow.add(sinkerNameLabel);

            JLabel sinkerPriceLabel = new JLabel("Price");
            sinkerHeaderRow.add(sinkerPriceLabel);

            JLabel sinkerQtyLabel = new JLabel("Quantity");
            sinkerHeaderRow.add(sinkerQtyLabel);

            JLabel sinkerCalorieLabel = new JLabel("Calorie");
            sinkerHeaderRow.add(sinkerCalorieLabel);

            // Set line border for the header row
            Border sinkerHeaderBorder = BorderFactory.createLineBorder(Color.BLACK);
            sinkerHeaderRow.setBorder(sinkerHeaderBorder);
            panel.add(sinkerHeaderRow);

            // Display the Sinkers and their details
            String[] sinkers = controller.getSinkers();
            double[] sinkerPrices = controller.getSinkersPrices();
            int[] sinkerQuantities = controller.getSinkerServing();
            double[] sinkerCalories = controller.getSinkersCalories();

            for (int i = 0; i < sinkers.length; i++) {
                JPanel row = new JPanel(new GridLayout(1, 3, 10, 10));
                JLabel sinkerName = new JLabel(sinkers[i]);
                row.add(sinkerName);

                JLabel sinkerPrice = new JLabel(String.valueOf(sinkerPrices[i]));
                row.add(sinkerPrice);

                JLabel sinkerQty = new JLabel(String.valueOf(sinkerQuantities[i]));
                row.add(sinkerQty);

                JLabel sinkerCalorie = new JLabel(String.valueOf(sinkerCalories[i]));
                row.add(sinkerCalorie);

                // Set line border for each row
                Border rowBorder = BorderFactory.createLineBorder(Color.BLACK);
                row.setBorder(rowBorder);
                panel.add(row);
            }

            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.setBackground(Color.GRAY);

            // Create a button for maintenance
            JButton maintenanceButton = new JButton("Maintenance");
            maintenanceButton.addActionListener(e -> specMaintenance(controller));
            buttonPanel.add(maintenanceButton);

            // Create a button for purchasing
            JButton insertButton = new JButton("Insert Money(Current Balance: " + controller.getSpecPayment() + ")");
            insertButton.addActionListener(e -> SpecPayment(controller));
            buttonPanel.add(insertButton);

            // Create a button for purchasing
            JButton purchaseButton = new JButton("Buy");
            purchaseButton.addActionListener(e -> specBuy(controller));
            buttonPanel.add(purchaseButton);

            // Create a button for change
            JButton changeButton = new JButton("Get Change");
            changeButton.addActionListener(e -> specChange(controller));
            buttonPanel.add(changeButton);


            // Go back to the main menu
            JButton backButton = new JButton("Go Back to Main Menu");
            backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
            buttonPanel.add(backButton);

            panel.add(buttonPanel); // Add the button panel beneath the products

            mainPanel.add(panel, "SpecialVendingMachinePanel"); // Add the panel to mainPanel
            cardLayout.show(mainPanel, "SpecialVendingMachinePanel");
        }
    }

    public void specMaintenance(Controller controller){
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.GRAY);

        //add item quantity
        JButton addItemButton = new JButton("Add MilkTea Flavor Quantity");
        addItemButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter the name of Milk Flavor:", "Add Item Quantity", JOptionPane.QUESTION_MESSAGE);
            int qty = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the added quantity:", "Add Item Quantity", JOptionPane.QUESTION_MESSAGE));
            controller.addMilkServing(name, qty);
        });
        buttonPanel.add(addItemButton);

        //add sinker quantity
        JButton addItemButton1   = new JButton("Add MilkTea Sinker Quantity");
        addItemButton1.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter the name of Milk Flavor:", "Add Item Quantity", JOptionPane.QUESTION_MESSAGE);
            int qty = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the added quantity:", "Add Item Quantity", JOptionPane.QUESTION_MESSAGE));
            controller.addSinkerServing(name, qty);
        });
        buttonPanel.add(addItemButton1);

        JButton addMoneyBoxButton = new JButton("Add to MoneyBox(Current Money Box Balance: " + controller.getSpecMoneyBox() + ")");
        addMoneyBoxButton.addActionListener(e -> {
            double money = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the Amount added: ", "Add Moneybox Amount", JOptionPane.QUESTION_MESSAGE));
            controller.addSpecMoneyBox(money);
        });
        buttonPanel.add(addMoneyBoxButton);

        JButton backButton = new JButton("Go Back to Vending Machine");
        backButton.addActionListener(e -> testSpecialVendingMachine(controller));
        buttonPanel.add(backButton);

        mainPanel.add(buttonPanel, "specMaintenance");
        cardLayout.show(mainPanel, "specMaintenance");
    }

    public void SpecPayment(Controller controller) {
        String[] paymentOptions = {
                "1 Peso Coin",
                "5 Peso Coin",
                "10 Peso Coin",
                "20 Peso Coin/Bill",
                "50 Peso Bill",
                "100 Peso Bill",
                "200 Peso Bill",
                "500 Peso Bill",
                "1000 Peso Bill",
                "Cancel"
        };

        int result = JOptionPane.showOptionDialog(
                null,
                "Select a Bill/Coin:",
                "Payment Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                paymentOptions,
                paymentOptions[0]
        );

        if (result >= 0 && result < paymentOptions.length - 1) {
            String selectedOption = paymentOptions[result];
            JOptionPane.showMessageDialog(null, "Selected Bill/Coin: " + selectedOption);

            switch (selectedOption) {
                case "1 Peso Coin":
                    controller.addSpecPayment(1.0);
                    break;
                case "5 Peso Coin":
                    controller.addSpecPayment(5.0);
                    break;
                case"10 Peso Coin":
                    controller.addSpecPayment(10.0);
                    break;
                case "20 Peso Coin/Bill":
                    controller.addSpecPayment(20.0);
                    break;
                case "50 Peso Bill":
                    controller.addSpecPayment(50.0);
                    break;

                case "100 Peso Bill":
                    controller.addSpecPayment(100.0);
                    break;

                case "200 Peso Bill":
                    controller.addSpecPayment(200.0);
                    break;
                case "500 Peso Bill":
                    controller.addSpecPayment(500.0);
                    break;

                case "1000 Peso Bill":
                    controller.addSpecPayment(1000.0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Payment canceled.");

            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Payment canceled.");
        }

        testSpecialVendingMachine(controller);
    }

    public void specBuy(Controller controller){
        int size = 0;
        double pay = controller.getSpecPayment();
        String[] Size = {
                "Small",
                "Medium",
                "Large",
                "Cancel"
        };

        int result = JOptionPane.showOptionDialog(
                null,
                "Select the Size of Milk Tea:",
                "Size Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Size,
                Size[0]
        );

            String selectedOption = Size[result];
            JOptionPane.showMessageDialog(null, "Selected Size: " + selectedOption);

            if (Size.equals("Small")) {
                size = 1;
            } else if (Size.equals("Medium")) {
                size = 2;
            } else if (Size.equals("Large")) {
                size = 3;
            }


        String[] sugarLevel = {
                "0%",
                "25%",
                "50%",
                "75%",
                "100%",
                "125%",
                "150%",
                "Cancel"
        };
        int result1 = JOptionPane.showOptionDialog(
                null,
                "Select a Sugar Level:",
                "Sugar Level Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                sugarLevel,
                sugarLevel[0]
        );
            String selectedOption1 = sugarLevel[result1];
            JOptionPane.showMessageDialog(null, "Selected Sugar Level: " + selectedOption);

            switch (selectedOption1) {
                case "0%":
                    controller.setSugarLevel(1);
                    break;
                case "25%":
                    controller.setSugarLevel(2);
                    break;
                case"50%":
                    controller.setSugarLevel(3);
                    break;
                case "75%":
                    controller.setSugarLevel(4);
                    break;
                case "100%":
                    controller.setSugarLevel(5);
                    break;
                case "125%":
                    controller.setSugarLevel(6);
                    break;
                case "150%":
                    controller.setSugarLevel(7);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Payment canceled.");

            }




            String milkTea = JOptionPane.showInputDialog(this, "Enter the name of Milk Tea Flavor:", "Add Item Quantity", JOptionPane.QUESTION_MESSAGE);
            controller.buyMilkTea(milkTea);


            String sinker = JOptionPane.showInputDialog(this, "Enter the name of sinker:", "Add Item Quantity", JOptionPane.QUESTION_MESSAGE);
            controller.buySinker(sinker);

            double milk = controller.getMilkTeaCalories(milkTea);
            double csinker = controller.getSinkerCalories(sinker);


        JOptionPane.showMessageDialog(null, "Order Bought!" +
                "Milk Tea Flavor: " + milkTea
                + "Sinker: " + sinker
                + "Sugar Level: " + selectedOption1
                + "Total Calories: " + controller.computeTotalCalories(milk, csinker, controller.getSugarLevel(), size)
                + "Total Price: " + controller.computePrice(milkTea, sinker, size));

        double bill = controller.computePrice(milkTea, sinker, size);
        controller.setSpecPayment(pay - bill);
        testSpecialVendingMachine(controller);

    }

    public void specChange(Controller controller){
        double change = controller.getSpecPayment();
        controller.setSpecPayment(0);
        JOptionPane.showMessageDialog(null, "Change: " + change);
        controller.setSpecMoneyBox(controller.getSpecMoneyBox() - change);
        testSpecialVendingMachine(controller);
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(VendingMachineGUI::new);
    }
}
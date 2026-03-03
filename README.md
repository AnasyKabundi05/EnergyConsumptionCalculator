# EnergyConsumptionCalculator

OOP2 – Practical 06 – GUI Basics

## Project Description

EnergyConsumptionCalculator is a Java Swing application developed using the IntelliJ GUI Builder. The application allows the user to select an appliance, enter the number of hours used per day, and calculate the energy consumption and cost per day, month, and year.

## Learning Outcomes

1. Use the IntelliJ GUI Builder
2. Develop code to handle GUI events

## Application Requirements

### Appliances (JComboBox Options)

* Microwave Oven – 800 Watts
* Laptop – 50 Watts
* Dishwasher – 2000 Watts

When the user selects a different appliance from the JComboBox, the Power Consumption TextField must automatically update to display the correct wattage.

## Energy Consumption Calculation

Energy per day (kWh/day) is calculated using the formula:

E (kWh/day) = (P × T) / 1000

Where:
P = Power in Watts
T = Time in hours per day

Example:
(800 × 0.25) / 1000 = 0.2 kWh/day

Additional calculations:
Energy per month = Energy per day × 31
Energy per year = Energy per day × 365

## Cost Calculation

Declare a constant in the bound class:

private static final double UNIT_RATE = 26.41;

The unit rate is 26.41 cents per kWh.

Cost calculations:

* Cost per day = Energy per day × UNIT_RATE
* Divide by 100 to convert cents to euros
* Cost per month = Cost per day × 31
* Cost per year = Cost per day × 365

Currency values must be displayed using NumberFormat.getCurrencyInstance().

## Reset Button Requirements

When the Reset button is clicked:

* Clear all calculated fields
* Set the appliance selection to Microwave Oven
* Set the power consumption field to 800
* Do not clear the appliance or power fields

## GUI Design Requirements

Panel background colours:

* Input Panel: rgb(177, 227, 247)
* Energy Panel: rgb(242, 242, 242)
* Cost Panel: rgb(150, 190, 238)

TextField rules:

* All TextFields must be non-editable except hoursTextField
* Only hoursTextField should be editable

## Exception Handling

If the user enters a non-numeric value in hoursTextField, handle the exception using a try-catch block to prevent the application from crashing. Display an error message using JOptionPane.

Example:

try {
double hours = Double.parseDouble(hoursTextField.getText());
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(null,
"Please enter a valid numeric value for hours.",
"Invalid Input",
JOptionPane.ERROR_MESSAGE);
}

## Event Handling Requirements

You must handle:

* JComboBox selection change event
* Calculate button click event
* Reset button click event

## Project Name

EnergyConsumptionCalculator

This project demonstrates GUI design, event-driven programming, calculations, currency formatting, and exception handling in Java Swing.

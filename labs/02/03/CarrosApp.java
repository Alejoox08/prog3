import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarrosApp extends JFrame {
    private JTextField marcaTextField, modeloTextField, colorTextField, kilometrajeTextField;
    private JButton agregarCarroButton, ordenarPorModeloButton, ordenarPorKilometrajeButton;
    private JTextArea resultadoTextArea;
    private Carro[] arregloDeCarros;
    private int cantidadDeCarros = 0;

    public CarrosApp() {
        setTitle("Gestión de Carros Usados");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel entradaPanel = new JPanel(new GridLayout(4, 2));
        entradaPanel.add(new JLabel("Marca:"));
        marcaTextField = new JTextField();
        entradaPanel.add(marcaTextField);
        entradaPanel.add(new JLabel("Modelo:"));
        modeloTextField = new JTextField();
        entradaPanel.add(modeloTextField);
        entradaPanel.add(new JLabel("Color:"));
        colorTextField = new JTextField();
        entradaPanel.add(colorTextField);
        entradaPanel.add(new JLabel("Kilometraje:"));
        kilometrajeTextField = new JTextField();
        entradaPanel.add(kilometrajeTextField);

        agregarCarroButton = new JButton("Agregar Carro");
        entradaPanel.add(agregarCarroButton);

        JPanel resultadoPanel = new JPanel();
        resultadoPanel.setLayout(new BorderLayout());
        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoTextArea);
        resultadoPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel ordenamientoPanel = new JPanel(new FlowLayout());
        ordenarPorModeloButton = new JButton("Ordenar por Modelo");
        ordenamientoPanel.add(ordenarPorModeloButton);
        ordenarPorKilometrajeButton = new JButton("Ordenar por Kilometraje");
        ordenamientoPanel.add(ordenarPorKilometrajeButton);

        add(entradaPanel, BorderLayout.NORTH);
        add(resultadoPanel, BorderLayout.CENTER);
        add(ordenamientoPanel, BorderLayout.SOUTH);

        arregloDeCarros = new Carro[100]; 

        agregarCarroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCarro();
            }
        });

        ordenarPorModeloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarPorModelo();
            }
        });

        ordenarPorKilometrajeButton.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarPorKilometraje();
            }
        });
    }

    private void agregarCarro() {
        if (cantidadDeCarros < arregloDeCarros.length) {
            String marca = marcaTextField.getText();
            String modelo = modeloTextField.getText();
            String color = colorTextField.getText();
            double kilometraje = Double.parseDouble(kilometrajeTextField.getText());

            arregloDeCarros[cantidadDeCarros] = new Carro(marca, modelo, color, kilometraje);
            cantidadDeCarros++;

            mostrarCarros();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pueden agregar más carros.");
        }
    }

    private void ordenarPorModelo() {
        if (cantidadDeCarros > 0) {
      
            for (int i = 0; i < cantidadDeCarros - 1; i++) {
                for (int j = 0; j < cantidadDeCarros - i - 1; j++) {
                    if (arregloDeCarros[j].getModelo().compareTo(arregloDeCarros[j + 1].getModelo()) > 0) {
                 
                        Carro temp = arregloDeCarros[j];
                        arregloDeCarros[j] = arregloDeCarros[j + 1];
                        arregloDeCarros[j + 1] = temp;
                    }
                }
            }

            mostrarCarros();
        } else {
            JOptionPane.showMessageDialog(this, "No hay carros para ordenar.");
        }
    }

    private void ordenarPorKilometraje() {
        if (cantidadDeCarros > 0) {
        
            for (int i = 0; i < cantidadDeCarros - 1; i++) {
                for (int j = 0; j < cantidadDeCarros - i - 1; j++) {
                    if (arregloDeCarros[j].getKilometraje() > arregloDeCarros[j + 1].getKilometraje()) {
                   
                        Carro temp = arregloDeCarros[j];
                        arregloDeCarros[j] = arregloDeCarros[j + 1];
                        arregloDeCarros[j + 1] = temp;
                    }
                }
            }

            mostrarCarros();
        } else {
            JOptionPane.showMessageDialog(this, "No hay carros para ordenar.");
        }
    }

    private void mostrarCarros() {
        resultadoTextArea.setText("");
        for (int i = 0; i < cantidadDeCarros; i++) {
            resultadoTextArea.append(arregloDeCarros[i].toString() + "\n");
        }
    }

    private void limpiarCampos() {
        marcaTextField.setText("");
        modeloTextField.setText("");
        colorTextField.setText("");
        kilometrajeTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CarrosApp().setVisible(true);
            }
        });
    }
}

class Carro {
    private String marca;
    private String modelo;
    private String color;
    private double kilometraje;

    public Carro(String marca, String modelo, String color, double kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.kilometraje = kilometraje;
    }

    public String getModelo() {
        return modelo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color + ", Kilometraje: " + kilometraje;
    }
}

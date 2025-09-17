package gui;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import livro.gerenciar.LivroDAO;
import livro.Livro;// sua entidade JPA

public class LivroTableModel extends AbstractTableModel {

    private final String[] colunas = {"ID", "Nome", "Categoria", "Resumo"};
    private final List<Livro> dados = new ArrayList<>();

    @Override
    public int getRowCount() { return dados.size(); }

    @Override
    public int getColumnCount() { return colunas.length; }

    @Override
    public String getColumnName(int column) { return colunas[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livro l = dados.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> l.getId();
            case 1 -> l.getNome();
            case 2 -> l.getCategoria();
            case 3 -> l.getResumo();
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // desativa edição direta na tabela
    }

    // Atualiza a lista inteira
    public void setLivros(List<Livro> lista) {
        dados.clear();
        if (lista != null) dados.addAll(lista);
        fireTableDataChanged();
    }
}

package User;

/**
 * Rappresenta un utente del gioco
 */
public class User {

    /**
     * il nome dell'utente
     */
    private String nome;
    private boolean colore;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isColore() {
        return colore;
    }

    public void setColore(boolean colore) {
        this.colore = colore;
    }


}

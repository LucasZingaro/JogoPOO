package jogo.modelo;

/**
 * Status
 * 
 * @author Lucas
 */
public enum StatusEnum {
    /** Voando */
    FLYING,
    /** Crescendo*/
    GROWING,
    /** Neutro*/
    NEUTRAL,
    /** Decrescente*/
    DESCENDING,
    /** Depressão*/
    DEPRESSION;

    private void setValue(StatusEnum status, StatusEnum value){
        status = value;
    }
    
    public void setStatus(StatusEnum status) {
        this.setValue(this, status);
    }
    
    @Override
    public String toString() {
        switch(this){
            case FLYING: return "Voando";
            case GROWING: return "Crescendo";
            case NEUTRAL: return "Neutro";
            case DESCENDING: return "Decrescendo";
            case DEPRESSION: return "Depressão";
            default: return "none";
        }
    }
}

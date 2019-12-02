package jogo.modelo;

/**
 * Status
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
    
    public static StatusEnum parseStatusEnum(String sStatusEnum){
        if(sStatusEnum.equals(StatusEnum.DEPRESSION.toString())){
            return StatusEnum.DEPRESSION;
        }
        if(sStatusEnum.equals(StatusEnum.DESCENDING.toString())){
            return StatusEnum.DESCENDING;
        }
        if(sStatusEnum.equals(StatusEnum.NEUTRAL.toString())){
            return StatusEnum.NEUTRAL;
        }
        if(sStatusEnum.equals(StatusEnum.GROWING.toString())){
            return StatusEnum.GROWING;
        }
        if(sStatusEnum.equals(StatusEnum.FLYING.toString())){
            return StatusEnum.FLYING;
        }
        return null;
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

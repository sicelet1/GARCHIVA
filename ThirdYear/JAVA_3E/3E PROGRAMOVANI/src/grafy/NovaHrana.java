package grafy;

import lombok.Data;

@Data
public class NovaHrana {
    private final NovyVrchol vrcholA;
    private final NovyVrchol vrcholB;

    public NovaHrana(final NovyVrchol vrcholA, final NovyVrchol vrcholB) {

        this.vrcholA = vrcholA;
        this.vrcholB = vrcholB;
    }

    public boolean jsemTvujVrchol(NovyVrchol v) {

        return v == vrcholA || v == vrcholB;
    }

    public NovyVrchol dejMiSouseda(NovyVrchol v) {

        if (v != vrcholA && v != vrcholB)
            return null;

        return v == vrcholA ? vrcholB : vrcholA;
    }
}

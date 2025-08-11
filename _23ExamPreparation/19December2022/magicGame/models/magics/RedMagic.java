package magicGame.models.magics;

public class RedMagic extends MagicImpl {

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {

        if (getBulletsCount() >= 1) {

            declineBullets(1);
            return 1;
        }
        return 0;
    }
}

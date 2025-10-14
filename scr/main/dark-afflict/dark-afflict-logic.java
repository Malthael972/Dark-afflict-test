package darkafflict;

import mindustry.mod.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.entities.bullet.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.meta.*;
import mindustry.ctype.*;
import mindustry.gen.*;

public class DarkAfflictMod extends Mod {

    public DarkAfflictMod() {
        // Constructor (runs before content is loaded)
        Log.info("Dark Afflict mod loaded successfully.");
    }

    @Override
    public void loadContent() {
        Log.info("Loading Dark Afflict content...");

        // Example: clone of the Afflict turret behavior
        LaserTurret darkAfflict = new LaserTurret("dark-afflict") {{
            requirements(Category.turret, with(Items.silicon, 150, Items.beryllium, 180, Items.tungsten, 130));
            localizedName = "Dark Afflict";
            description = "A dark-energy version of the Afflict turret that fires twin mirrored beams.";
            size = 3;
            health = 2600;
            reload = 90f;
            range = 240f;
            powerUse = 15f;
            shootSound = Sounds.laser;

            shoot = new ShootAlternate() {{
                shots = 2;
                spread = 6f;
            }};

            shootType = new ContinuousLaserBulletType() {{
                damage = 80f;
                length = 240f;
                width = 3.5f;
                colors = new Color[]{Color.valueOf("ff0000"), Color.valueOf("660000"), Color.valueOf("000000")};
                hitEffect = Fx.hitLaser;
                lifetime = 60f;
                shake = 1f;
                sideAngle = 15f;
                sideWidth = 1.5f;
                sideLength = 60f;
                largeHit = true;
            }};
        }};
    }
}

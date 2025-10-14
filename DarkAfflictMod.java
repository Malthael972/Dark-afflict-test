package darkafflict;

import arc.util.Log;
import arc.graphics.Color;
import mindustry.mod.Mod;
import mindustry.content.Items;
import mindustry.type.ItemStack;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.type.Category;
import mindustry.content.Fx;
import mindustry.gen.Sounds;

public class DarkAfflictMod extends Mod {
    public DarkAfflictMod() {
        Log.info("Dark Afflict mod constructor called.");
    }

    @Override
    public void loadContent(){
        Log.info("Dark Afflict: registering blocks...");

        // Create a LaserTurret similar to Afflict
        LaserTurret darkAfflict = new LaserTurret("dark-afflict"){{
            localizedName = "Dark Afflict";
            description = "A dark-energy version of the Afflict turret that fires twin mirrored beams.";
            size = 3;
            health = 2600;
            reload = 90f;
            range = 240f;
            powerUse = 15f;
            shootSound = Sounds.laser;

            requirements(Category.turret, ItemStack.with(
                Items.silicon, 150,
                Items.beryllium, 180,
                Items.tungsten, 130
            ));

            // Alternate two-shot pattern (mirrored)
            shoot = new mindustry.world.blocks.defense.turrets.ShootAlternate(){{
                shots = 2;
                spread = 6f;
            }};

            // Continuous laser beam properties (close to vanilla Afflict)
            shootType = new ContinuousLaserBulletType(){{
                damage = 80f;
                length = 240f;
                width = 3.5f;
                colors = new Color[]{Color.valueOf("4c4cff"), Color.valueOf("7a7aff"), Color.white};
                hitEffect = Fx.hitLaser;
                lifetime = 60f;
                shake = 1f;
                sideAngle = 15f;
                sideWidth = 1.5f;
                sideLength = 60f;
                largeHit = true;
            }};
        }};

        Log.info("Dark Afflict: done registering.");
    }
}

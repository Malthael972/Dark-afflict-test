package darkafflict;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.mod.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.meta.*;
import static mindustry.type.ItemStack.with;

public class DarkAfflictMod extends Mod {
    
    public static Block darkAfflict;
    
    @Override
    public void loadContent() {
        darkAfflict = new ItemTurret("dark-afflict"){{
            requirements(Category.turret, with(
                Items.beryllium, 100,
                Items.tungsten, 80,
                Items.thorium, 50,
                Items.carbide, 40
            ));
            
            envEnabled = Env.space;
            size = 3;
            health = 1280;
            reload = 6f;
            range = 220f;
            shootCone = 3f;
            rotateSpeed = 4f;
            
            shoot = new ShootPattern(){{ shots = 2; shotDelay = 0f; }};
            xRand = 4f;
            
            ammo(
                Items.beryllium, new LaserBoltBulletType(5.5f, 38){{
                    lifetime = 40f;
                    healPercent = 2f;
                    collidesTeam = true;
                    backColor = Color.valueOf("ff0000");
                    frontColor = Color.valueOf("ff4444");
                }},
                Items.tungsten, new LaserBoltBulletType(5.5f, 48){{
                    lifetime = 40f;
                    healPercent = 3.5f;
                    collidesTeam = true;
                    backColor = Color.valueOf("dd0000");
                    frontColor = Color.valueOf("ff3333");
                }},
                Items.thorium, new LaserBoltBulletType(5.5f, 55){{
                    lifetime = 40f;
                    healPercent = 1.5f;
                    status = StatusEffects.burning;
                    statusDuration = 300f;
                    collidesTeam = true;
                    backColor = Color.valueOf("cc0000");
                    frontColor = Color.valueOf("ff5555");
                }},
                Items.carbide, new LaserBoltBulletType(6f, 62){{
                    lifetime = 40f;
                    healPercent = 4f;
                    homingPower = 0.08f;
                    homingRange = 100f;
                    collidesTeam = true;
                    backColor = Color.valueOf("aa0000");
                    frontColor = Color.valueOf("ff6666");
                }}
            );
            
            researchCost = with(
                Items.beryllium, 3000,
                Items.tungsten, 2500,
                Items.thorium, 1500,
                Items.carbide, 1000
            );
        }};
    }
}

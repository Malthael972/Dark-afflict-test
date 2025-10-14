Dark Afflict - Java mod skeleton for Mindustry (Build 146)
--------------------------------------------------------

What this package contains:
- src/main/java/darkafflict/DarkAfflictMod.java  (main mod class)
- mod.json + mod.hjson                         (mod manifest files)
- assets/content/...                           (placeholder turret hjson & sprite)
- build.gradle & settings.gradle               (Gradle build files)
- libs/                                        (for placing mindustry.jar if you have it)

How to build:
1. Obtain a Mindustry core jar for build 146. You can either:
   - Place a compatible mindustry.jar into the 'libs/' folder, and uncomment the implementation line
     in build.gradle:
       implementation files('libs/mindustry.jar')
   - OR configure a Maven dependency if you have a repository for Mindustry (not included by default).
2. Run: ./gradlew build
   The compiled jar will be in build/libs/ (named DarkAfflict-1.0-SNAPSHOT.jar or similar).
3. Place the resulting jar in your Mindustry 'mods/' folder alongside or instead of the assets folder.
   Mindustry will load the mod and run the DarkAfflictMod main class.

Notes:
- This skeleton registers a LaserTurret programmatically in loadContent().
- You can customize shootType, visuals, and behavior inside DarkAfflictMod.java.
- If you prefer content-only (no Java), move/inline bullet definitions into assets/content/blocks/... hjson.

package customsound;

import arc.Events;
import arc.audio.Music;
import arc.audio.Sound;
import arc.files.Fi;
import arc.util.Log;
import mindustry.game.EventType;
import mindustry.gen.Musics;
import mindustry.gen.Sounds;
import mindustry.mod.Mod;

import static mindustry.Vars.*;

public class CustomSoundMod extends Mod {

    @Override
    public void init() {
        if (headless) return;

        Events.on(EventType.ClientLoadEvent.class, e -> {
            replaceSounds();
            replaceMusic();
        });
    }

    private void replaceSounds() {
        Fi tapFile = tree.get("sounds/tap.ogg");
        Log.info("[CustomSoundMod] tapFile exists: " + tapFile.exists());
        if (tapFile.exists()) {
            try {
                Sound customTap = new Sound(tapFile);
                Sounds.click = customTap;
                Sounds.back = customTap;
            } catch (Exception e) {
                Log.err("[CustomSoundMod] Failed to load tap sound", e);
            }
        }
    }

    private void replaceMusic() {
        Fi menuFile = tree.get("music/menu.ogg");
        Log.info("[CustomSoundMod] menuFile exists: " + menuFile.exists());
        if (menuFile.exists()) {
            try {
                Music customMenu = new Music(menuFile);
                customMenu.setLooping(true);
                Musics.menu = customMenu;
            } catch (Exception e) {
                Log.err("[CustomSoundMod] Failed to load menu music", e);
            }
        }
    }
}

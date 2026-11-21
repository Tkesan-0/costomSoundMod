package customsound;

import arc.Events;
import arc.audio.Music;
import arc.audio.Sound;
import arc.files.Fi;
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
        if (tapFile.exists()) {
            Sound customTap = new Sound(tapFile);
            Sounds.buttonClick = customTap;
            Sounds.uiButton = customTap;
        }
    }

    private void replaceMusic() {
        Fi menuFile = tree.get("music/menu.ogg");
        if (menuFile.exists()) {
            Music customMenu = new Music(menuFile);
            Musics.menu = customMenu;
        }
    }
}

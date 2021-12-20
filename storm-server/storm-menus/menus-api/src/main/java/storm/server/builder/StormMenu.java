package storm.server.builder;

import storm.server.builder.animator.StormMenuAnimations;

public class StormMenu {

    private final String menuTitle;
    private final int size;
    private final StormMenuAnimations[] buttons;

    public StormMenu(String menuTitle, int size, StormMenuAnimations[] buttons) {
        this.menuTitle = menuTitle;
        this.size = size;
        this.buttons = buttons;
    }

    public int getSize() {
        return size;
    }

    public StormMenuAnimations[] getButtons() {
        return buttons;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public static final class StormMenuBuilder {
        private String menuTitle;
        private int size;
        private StormMenuAnimations[] buttons;

        public StormMenuBuilder menuTitle(String menuTitle) {
            this.menuTitle = menuTitle;
            return this;
        }

        public StormMenuBuilder menuSize(int size) {
            this.size = size;
            return this;
        }

        public StormMenuBuilder menuButtons(StormMenuAnimations[] buttons) {
            this.buttons = buttons;
            return this;
        }

        public StormMenu build() {
            return new StormMenu(
                    this.menuTitle,
                    this.size,
                    this.buttons
            );
        }
    }

}

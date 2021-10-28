public class ArchiveItem {
    private String identifier;
    private String name;

    public ArchiveItem(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof ArchiveItem)) {
            return false;
        }

        ArchiveItem comparedArchiveItem = (ArchiveItem) compared;

        return (this.identifier.equals(comparedArchiveItem.identifier));
    }

    public String toString() {
        return this.identifier + ": " + this.name;
    }
}

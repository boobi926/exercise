public class cover {
    public int rectCover(int target) {
        if(target<=2) return target;
        return rectCover(target-1)+rectCover(target-2);
    }
}

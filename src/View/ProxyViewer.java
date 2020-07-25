package View;

import Model.Board;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

public class ProxyViewer implements ViewerInterface {

    List<ViewerInterface> viewers;

    public ProxyViewer() {
        this.viewers = new ArrayList<ViewerInterface>();
    }

    public void addViewer(ViewerInterface newViewer) {
        viewers.add(newViewer);
    }

    public void removeViewer(ViewerInterface viewer) {
        viewers.remove(viewer);
    }

    @Override
    public void display(Board board) {

    }
}

package videos;

import javax.xml.stream.StreamFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    List<Channel> channels = new ArrayList<>();

    public void readDataFromFile(Path path) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
            writeIntoList(lines);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!");
        }
    }

    private void writeIntoList(List<String> lines) {
        lines.remove(0);
        for (String actualLine : lines ) {
            String[] tmp = actualLine.split(";");
            channels.add(new Channel(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }
    }

    public int calculateSumOfVideos() {
        int result = 0;
        for ( Channel actualChannel : channels ) {
            result += actualChannel.getNumberOfVideos();
        }
        return result;
    }

    public List<Channel> getChannels() {
        return channels;
    }
}

import java.util.Scanner;

// Node class representing each song in the playlist
class Node {
    String song;
    Node next;

    Node(String song) {
        this.song = song;
        this.next = null;
    }
}

// Linked List class for the Playlist
class Playlist {
    private Node head;

    // Add a song to the end of the playlist
    public void addSong(String song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println(song + " has been added to the playlist.");
    }

    // Remove a song from the playlist
    public void removeSong(String song) {
        if (head == null) {
            System.out.println("The playlist is empty.");
            return;
        }

        if (head.song.equals(song)) {
            head = head.next;
            System.out.println(song + " has been removed from the playlist.");
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.song.equals(song)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println(song + " has been removed from the playlist.");
        } else {
            System.out.println(song + " not found in the playlist.");
        }
    }

    // Display the playlist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("The playlist is empty.");
            return;
        }
        Node current = head;
        System.out.println("Current Playlist:");
        while (current != null) {
            System.out.println("- " + current.song);
            current = current.next;
        }
    }

    // Play a song (just prints the song title)
    public void playSong(String song) {
        Node current = head;
        while (current != null) {
            if (current.song.equals(song)) {
                System.out.println("Now playing: " + song);
                return;
            }
            current = current.next;
        }
        System.out.println(song + " not found in the playlist.");
    }

    // Create playlist from user input
    public void createPlaylist(String songsInput) {
        String[] songs = songsInput.split(",");
        for (String song : songs) {
            addSong(song.trim()); // Add each song after trimming whitespace
        }
    }
}

// Main class to manage the user interface
public class PlaylistManager2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        String command;

        System.out.println("Welcome to the Playlist Manager!");
        while (true) {
            System.out.println("\nAvailable commands: add, remove, display, play, create, exit");
            System.out.print("Enter a command: ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter song title to add: ");
                    String songToAdd = scanner.nextLine();
                    playlist.addSong(songToAdd);
                    break;
                case "remove":
                    System.out.print("Enter song title to remove: ");
                    String songToRemove = scanner.nextLine();
                    playlist.removeSong(songToRemove);
                    break;
                case "display":
                    playlist.displayPlaylist();
                    break;
                case "play":
                    System.out.print("Enter song title to play: ");
                    String songToPlay = scanner.nextLine();
                    playlist.playSong(songToPlay);
                    break;
                case "create":
                    System.out.print("Enter song titles separated by commas to create a playlist: ");
                    String songsInput = scanner.nextLine();
                    playlist.createPlaylist(songsInput);
                    break;
                case "exit":
                    System.out.println("Exiting Playlist Manager. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}

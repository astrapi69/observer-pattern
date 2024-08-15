/**
 * The MIT License
 *
 * Copyright (C) 2022 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.design.pattern.observer.chat.example;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import io.github.astrapi69.design.pattern.observer.chat.IUser;

/**
 * The class {@link ChatApp} demonstrates a simple chat application using the observer design
 * pattern It creates a chat room and allows multiple users to send and receive messages in
 * real-time using a graphical user interface (GUI).
 */
public class ChatApp
{
	private JFrame frame;
	private JTextArea chatArea;
	private JTextField inputField;
	private ChatRoom<StringMessage> chatRoom;

	/**
	 * The main method to start the chat application.
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(ChatApp::new);
	}

	/**
	 * Constructor for {@code ChatApp}, initializing the application.
	 */
	public ChatApp()
	{
		initialize();
	}

	/**
	 * Initializes the chat room, users, and the GUI components.
	 */
	private void initialize()
	{
		// Create the chat room
		chatRoom = new ChatRoom<>("General");

		// Create some users
		User user1 = new User("Alice", 1);
		User user2 = new User("Bob", 2);

		// Register the users in the chat room
		ChatRoomUser<StringMessage> chatUser1 = new ChatRoomUserImpl(chatRoom, user1);
		ChatRoomUser<StringMessage> chatUser2 = new ChatRoomUserImpl(chatRoom, user2);

		// Set up the frame
		frame = new JFrame("Chat Room");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLayout(new BorderLayout());

		// Create chat area
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);

		// Create input field
		inputField = new JTextField();
		inputField.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String text = inputField.getText();
				if (!text.isEmpty())
				{
					StringMessage message = new StringMessage(text);
					chatUser1.send(message);
					inputField.setText("");
				}
			}
		});
		frame.add(inputField, BorderLayout.SOUTH);

		// Show the frame
		frame.setVisible(true);

		// Simulate a message from another user
		Timer timer = new Timer(5000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				StringMessage message = new StringMessage("Hello from " + user2.getName() + "!");
				chatUser2.send(message);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}

	/**
	 * Implementation of a simple {@link ChatRoomUser} that updates the chat area when a message is
	 * received.
	 */
	private class ChatRoomUserImpl extends ChatRoomUser<StringMessage>
	{
		public ChatRoomUserImpl(ChatRoom<StringMessage> room, IUser<?> user)
		{
			super(room, user);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void execute()
		{
			SwingUtilities.invokeLater(() -> chatArea
				.append(getUser().getName() + ": " + getObservable().getValue() + "\n"));
		}
	}
}

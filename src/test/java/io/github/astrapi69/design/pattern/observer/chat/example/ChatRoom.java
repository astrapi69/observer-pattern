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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.github.astrapi69.design.pattern.observer.AbstractSubject;
import io.github.astrapi69.design.pattern.observer.chat.IUser;
import io.github.astrapi69.design.pattern.observer.chat.Message;
import io.github.astrapi69.design.pattern.observer.chat.Room;

/**
 * The class {@link ChatRoom} represents a chat room where users can exchange messages It extends
 * the {@link AbstractSubject} class and implements the {@link Room} interface, managing the list of
 * participants and message history.
 *
 * @param <M>
 *            the type of messages that are exchanged in this chat room
 */
public class ChatRoom<M extends Message<?>> extends AbstractSubject<M, ChatRoomUser<M>>
	implements
		Room<M>,
		Serializable
{
	private static final long serialVersionUID = 1L;
	private final List<ChatRoomUser<M>> observers = new ArrayList<>();
	private final List<M> messageHistory = new ArrayList<>();
	private final String name;
	private M observable;

	/**
	 * Constructor for creating a {@code ChatRoom} with a specified name.
	 *
	 * @param name
	 *            the name of the chat room
	 */
	public ChatRoom(String name)
	{
		this.name = name;
	}

	/**
	 * Constructor for creating a {@code ChatRoom} with a specified initial message and name.
	 *
	 * @param observable
	 *            the initial message of the chat room
	 * @param name
	 *            the name of the chat room
	 */
	public ChatRoom(M observable, String name)
	{
		this.observable = observable;
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void add(ChatRoomUser<M> observer)
	{
		observers.add(observer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAll(Collection<ChatRoomUser<M>> observers)
	{
		this.observers.addAll(observers);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IUser<?>> getChatRoomUsers()
	{
		List<IUser<?>> chatRoomUsers = new ArrayList<>();
		for (ChatRoomUser<M> chatUser : observers)
		{
			chatRoomUsers.add(chatUser.getUser());
		}
		return chatRoomUsers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<M> getMessageHistory()
	{
		return messageHistory;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized M getObservable()
	{
		return observable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void setObservable(M observable)
	{
		this.observable = observable;
		messageHistory.add(observable);
		updateObservers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSecure()
	{
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void remove(ChatRoomUser<M> observer)
	{
		observers.remove(observer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAll(Collection<ChatRoomUser<M>> observers)
	{
		this.observers.removeAll(observers);
	}

	/**
	 * Returns the number of users currently in the chat room.
	 *
	 * @return the number of users in the chat room
	 */
	public int size()
	{
		return observers.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void updateObservers()
	{
		for (ChatRoomUser<M> observer : observers)
		{
			observer.update(observable);
		}
	}

	/**
	 * Gets the name of the chat room.
	 *
	 * @return the name of the chat room
	 */
	public String getName()
	{
		return name;
	}
}

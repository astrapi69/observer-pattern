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

import io.github.astrapi69.design.pattern.observer.api.ActionCommand;
import io.github.astrapi69.design.pattern.observer.api.Observer;
import io.github.astrapi69.design.pattern.observer.chat.IUser;
import io.github.astrapi69.design.pattern.observer.chat.Message;

/**
 * The abstract class {@link ChatRoomUser} represents a user in a chat room that can send and
 * receive messages It implements the {@link Observer} and {@link ActionCommand} interfaces,
 * allowing it to observe changes in the chat room and execute commands.
 *
 * @param <M>
 *            the type of messages that this user handles
 */
public abstract class ChatRoomUser<M extends Message<?>>
	implements
		Observer<M>,
		ActionCommand,
		Serializable
{
	private static final long serialVersionUID = 1L;
	private final IUser<?> user;
	protected ChatRoom<M> subject;
	private M observable;

	/**
	 * Constructor for creating a {@code ChatRoomUser} with a specified chat room and user.
	 *
	 * @param room
	 *            the chat room that this user is participating in
	 * @param user
	 *            the user associated with this chat room user
	 */
	public ChatRoomUser(ChatRoom<M> room, IUser<?> user)
	{
		this.subject = room;
		this.observable = this.subject.getObservable();
		this.user = user;
		this.subject.add(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void update(M observable)
	{
		this.observable = observable;
		execute();
	}

	/**
	 * Gets the current observable message.
	 *
	 * @return the current observable message
	 */
	public synchronized M getObservable()
	{
		return observable;
	}

	/**
	 * Gets the user associated with this chat room user.
	 *
	 * @return the user associated with this chat room user
	 */
	public IUser<?> getUser()
	{
		return user;
	}

	/**
	 * Sends a message to the chat room.
	 *
	 * @param message
	 *            the message to be sent
	 */
	public void send(M message)
	{
		subject.setObservable(message);
	}
}

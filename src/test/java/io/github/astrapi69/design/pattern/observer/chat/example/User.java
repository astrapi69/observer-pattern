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

import io.github.astrapi69.design.pattern.observer.chat.IUser;

/**
 * The class {@link User} represents a user participating in the chat room It implements the
 * {@link IUser} interface, providing basic user information such as name and ID.
 */
public class User implements IUser<User>
{
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer id;

	/**
	 * Constructor for creating a {@code User} with a specified name and ID.
	 *
	 * @param name
	 *            the name of the user
	 * @param id
	 *            the ID of the user
	 */
	public User(String name, Integer id)
	{
		this.name = name;
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getApplicationUser()
	{
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setApplicationUser(User user)
	{
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getId()
	{
		return id;
	}

	/**
	 * Sets the ID of the user.
	 *
	 * @param id
	 *            the new ID of the user
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the user.
	 *
	 * @param name
	 *            the new name of the user
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}

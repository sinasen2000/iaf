package nl.nn.adapterframework.filesystem;

import java.io.File;

import org.junit.rules.TemporaryFolder;

import nl.nn.adapterframework.receivers.DirectoryListener;

public class LocalFileSystemListenerTest extends FileSystemListenerTest<File, LocalFileSystem>{

	public TemporaryFolder folder;

	@Override
	public FileSystemListener<File, LocalFileSystem> createFileSystemListener() {
		DirectoryListener result=new DirectoryListener();
		result.setRoot(folder.getRoot().getAbsolutePath());
		return result;
	}
	
	@Override
	public void setUp() throws Exception {
		folder = new TemporaryFolder();
		folder.create();
		super.setUp();
	}
	
	@Override
	protected IFileSystemTestHelper getFileSystemTestHelper() {
		return new LocalFileSystemTestHelper(folder);
	}



}
